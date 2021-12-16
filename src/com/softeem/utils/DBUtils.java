package com.softeem.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class DBUtils {

    /**
     * 驱动类路径
     */
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    /**
     * URL地址
     */
    private static final String URL = "jdbc:mysql://localhost:3306/school_student";
    /**
     * 登录数据库服务器的账号
     */
    private static final String USER = "root";
    /**
     * 登录数据库服务器的密码
     */
    private static final String PASSWORD = "123456";
    /**
     * 初始连接数
     */
    private static final int INIT_SIZE = 1;
    /**
     * 最大活动连接数
     */
    private static final int MAX_ACTIVE = 5;
    /**
     * 最长等待连接获取时间
     */
    private static final long MAX_WAIT = 5000;
    /**
     * 最小闲置连接数
     */
    private static final int MIN_IDLE = 1;

    /**
     * 声明数据源
     */
    private static DruidDataSource dataSource;

    static {
        dataSource = createDataSource();
    }

    /**
     * 创建连接池并返回
     *
     * @return
     */
    private static DruidDataSource createDataSource() {
        //创建连接池对象
        dataSource = new DruidDataSource();
        //设置连接数据库的基本字符串
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        //设置连接池的初始参数
        dataSource.setInitialSize(INIT_SIZE);
        dataSource.setMaxActive(MAX_ACTIVE);
        dataSource.setMaxWait(MAX_WAIT);
        dataSource.setMinIdle(MIN_IDLE);
        return dataSource;
    }

    /**
     * 返回数据库连接对象
     *
     * @return
     */
    public static Connection getConn() {
        try {
            //当连接池对象为null或者连接池对象被关闭时重新创建连接池
            if (dataSource == null || dataSource.isClosed()) {
                dataSource = createDataSource();
            }
            //返回连接
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭资源
     *
     * @param rs   结果集
     * @param stat 处理SQL的执行对象
     * @param conn 数据库连接
     */
    public static void close(ResultSet rs, Statement stat, Connection conn) {
        //ctrl+alt+t
        try {
            if (rs != null) {
                rs.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自动提交事务
     * 封装通用的更新操作（即通过该方法实现对于任意数据表的insert,update,delete操作）
     *
     * @param sql    需要被执行sql语句
     * @param params 执行sql语句时需要传递进去参数
     * @return 执行结果
     */
    public static boolean exeUpdate(String sql, Object... params) {
        Connection conn = getConn();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            //当传入的参数不为null时执行预处理
            if (Objects.nonNull(params)) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            //执行更新
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(null, ps, conn);
        }
        return false;
    }

    /**
     * 实现通用更新操作的方法，连接是需要外部提供的，事务可以在外部操作
     * 注意事项：该方法中出现异常必须抛出不能捕获，否则一旦出现异常，在当前方法就已经被catch，
     * 从而导致下一级调用者无法发现该异常，而导致事务无法回滚
     *
     * @param conn
     * @param sql
     * @param params
     * @return
     */
    public static boolean exeUpdate(Connection conn, String sql, Object... params) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            //当传入的参数不为null时执行预处理
            if (Objects.nonNull(params)) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            //执行更新
            return ps.executeUpdate() > 0;
        } finally {
            DBUtils.close(null, ps, null);
        }
    }

    /**
     * Object -> Map
     * 将查询的结果存储到一个List集合中，集合中的每一个元素即一个Map对象
     * （属性:属性值）
     * @return
     */
    public static List<Map<String,Object>> queryToMap(String sql,Object...params) {
        //声明List集合存储所有查询到的数据（内部的每一条数据使用一个Map对象表示）
        List<Map<String,Object>> list = new ArrayList<>();
        Connection conn = DBUtils.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            //执行预处理(如果存在占位符，则为占位符填充具体的值)
            if(Objects.nonNull(params)){
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i+1,params[i]);
                }
            }
            //执行查询
            rs = ps.executeQuery();
            //获取结果集元数据对象
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取总查询列数
            int columnCount = rsmd.getColumnCount();
            //遍历结果集
            while(rs.next()){
                //每一次循环执行创建一个Map(查询到一条数据)
                Map<String,Object> map = new HashMap<>();
                //获取每一列的列标签
                for (int i = 1; i <= columnCount ; i++) {
                    //获取指定的列名称
                    String cname = rsmd.getColumnName(i);
                    //根据列标签获取列值
                    Object value = rs.getObject(i);
                    //将一个查询列装入map
                    map.put(cname,value);
                }
                //将map集合（javabean）存储到List
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs,ps,conn);
        }
        return list;
    }

    /**
     * 封装通用查询单条数据的方法
     *
     * JDBC，反射，集合框架，lambda表达式，新增Objects类
     *
     * @param <T>
     * @param t
     * @param sql
     * @param params
     * @return
     */
    public static <T> T queryOne(Class<T> t, String sql, Object... params) {
        // 获取查询到到数据集合
        List<Map<String, Object>> list = queryToMap(sql, params);
        if (list.size() > 0) {
            // 获取一个Map对象
            Map<String, Object> map = list.get(0);
            // 将map集合转换为Javabean并返回
            return mapToBean(map, t);
        }
        return null;
    }

    /**
     * 封装通用查询多条数据的方法
     *
     * @param <T>
     * @param t
     * @param sql
     * @param params
     * @return
     */
    public static <T> List<T> queryList(Class<T> t, String sql, Object... params) {
        List<T> list = new ArrayList<T>();
        // 获取所有查询的到的数据
        List<Map<String, Object>> maps = queryToMap(sql, params);
        // 遍历集合中每一条数据(map)
        maps.forEach(m -> {
            // 将map转换为Javabean
            T obj = mapToBean(m, t);
            // 将Javabean装入list
            list.add(obj);
        });
        return list;
    }

    /**
     * 将Map集合转换为一个确定的类型
     *
     * @param <T>
     * @param map
     * @param t
     * @return
     */
    private static <T> T mapToBean(Map<String, Object> map, Class<T> t) {
        try {
            // 根据提供的Class对象创建对应类型的Object
            T obj = t.newInstance();
            map.forEach((k, v) -> {
                try {
                    // 根据Field名称获取字段对象
                    Field field = t.getDeclaredField(k);
                    // 设置字段的可访问性
                    field.setAccessible(true);
                    // 为字段设置值
                    field.set(obj, v);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // 返回对象
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getConn());
    }
}