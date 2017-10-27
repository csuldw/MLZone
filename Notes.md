config/index.js

```
proxyTable: {
        '/api':{
            target:'http://localhost:3030/',
            changeOrigin: true,
            pathRewrite:{
                '^/api':'/'
            }
        }
    },
```

### 20171026

1. 重构DAO类，简化代码
2. 修改分页功能

### 20171024

1. 修复中文搜索无法获取结果BUG；
	- mybatis数据库配置中的url中增加`?useUnicode=true&amp;characterEncoding=UTF-8`
2. 修改搜索方式，使用concat_ws进行搜索；
3. 增加根据关键字获取推荐列表；
4. 文章类别各个接口检验，确认无误。

### 20171022

1. 修改获取用户列表接口，增加分页
2. 增加`/user/getUserListByParam.do`接口的关键字搜索模糊功能


### 20171016修改部分

1. 项目增加log4j，输出日志；
2. 修改Dao包的文件命名，接口统一加上前缀“I”；
3. Dao接口中传递的单参数，统一加上@Param("param_name")；
4. 修改spring-mvc.xml的component-scan包名，将其制定到Controller的上上一层包；
