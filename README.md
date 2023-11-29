## 本项目实现的最终作用是基于JSP相册管理系统
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 上传图片
 - 相册分类管理
 - 相册管理
 - 管理员后台
 - 管理员登录
 - 系统设置
### 第2个角色为用户角色，实现了如下功能：
 - 查看和下载图片
 - 用户首页
 - 评论图片
## 数据库设计如下：
# 数据库设计文档

**数据库名：** photo_upload

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [admin](#admin) | 管理员表 |
| [leibie](#leibie) |  |
| [photo](#photo) |  |
| [pinglun](#pinglun) |  |
| [student](#student) |  |
| [systems](#systems) |  |

**表名：** <a id="admin">admin</a>

**说明：** 管理员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  3   | pass |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |

**表名：** <a id="leibie">leibie</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  3   | shuoming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 说明  |
|  4   | contenttime |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 发布时间  |

**表名：** <a id="photo">photo</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  3   | path |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 路径  |
|  4   | dianji |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  5   | contenttime |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 发布时间  |
|  6   | shuoming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 说明  |
|  7   | lid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="pinglun">pinglun</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | contentText |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | contentTime |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  5   | pid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="student">student</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | name |   varchar   | 50 |   0    |    N     |  N   |   '0'    |   |
|  3   | num |   varchar   | 50 |   0    |    N     |  N   |   '0'    |   |
|  4   | college_id |   int   | 10 |   0    |    N     |  N   |   0    |   |
|  5   | telphone |   varchar   | 50 |   0    |    N     |  N   |   '0'    |   |
|  6   | id_card_no |   varchar   | 50 |   0    |    N     |  N   |   '0'    |   |
|  7   | gender |   int   | 10 |   0    |    N     |  N   |   0    |   |
|  8   | account |   varchar   | 50 |   0    |    N     |  N   |   '0'    |   |
|  9   | password |   varchar   | 50 |   0    |    N     |  N   |   '0'    |   |

**表名：** <a id="systems">systems</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名字  |
|  3   | logopath |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | gonggao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公告  |

**运行不出来可以微信 javape 我的公众号：源码码头**
