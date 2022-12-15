## 版本：1.3.0.RELEASE ( 2022-12-12 )  Foxnic Version: 1.6.0.RELEASE
### 新特性
1、API 文档、数据库表结构文档支持
2、覆盖的新的代码模版文件
3、修改菜单生成的代码的 findDoc 方法
4、优化存储过程与函数调用
5、优化 SQL 对象化查询、执行接口

### Bug 修复
1、修复数值输入时存在的bug
2、修复人员、组织对话框按钮文字溢出的问题







































## 版本：1.2.0.RELEASE ( 2022-06-01 )  Foxnic Version: 1.5.2.RELEASE
### 新特性
1、流程审批支持流程图展示
2、Service 增加引用判断函数
3、控制器中增加是否可删除的判断
4、针对2、3点升级代码生成模板
5、增加 @Forbidde 标记禁用特性的 Rest 接口
6、在 header 中传入 nulls 只是后端是否返回 null 值
7、增加JS日志工具类
8、SQL 体系增加 parent 校验以及加入 clone 方法
9、代码生成 colorful badge 支持
10、查询与 Join 支持自定义字段

### Bug 修复
1、增加 首页、Tab组件、弹窗等 iframe 销毁逻辑，提升性能
2、修复序列创建后不能立即使用的bug
3、修复头像保存的bug
4、代码生成支持自定义 js 和 css 文件；
5、代码生成默认关闭 excel 导入导出；
6、流程中心 发起流程 按钮 权限分配禁用
7、日期组件选择显示到 Top 层
8、表格刷新时破碎感问题，更加平滑
9、代码生成支持 SelectBox 必填校验
10、新增角色时角色菜单未保存
11、修复数据字典显示上的bug
























## 版本：1.0.1.RELEASE ( 2022-04-08 )  Foxnic Version: 1.5.1.RELEASE
### 新特性
1、错误码机制优化
2、Camunda 流程支持
3、控制器参数校验机制
4、代码生成增加 readonly 特性
5、优化 Excel 生成的相关功能
6、增加 PerformanceLogger
7、代码生成支持指定表单提交地址   form.savingURL(ProcessInstanceServiceProxy.TEMPORARY_SAVE);
8、增加按唯一键查询方法: queryListByUKey,queryListByUKeys,queryMapByUKeys,queryListByIds,queryMapByIds,同时支持代码生成
9、增加 shadowBoolean 支持

### Bug 修复
1、代码生成 INPUT_FILED bug 修复
2、修复搜索栏自动换行时，表格按钮被遮盖问题
3、日期转换bug修复
4、接口参数接收bug修复
















## 版本：1.0.0.RELEASE ( 2022-01-20 )  Foxnic Version: 1.5.0.RELEASE
### 新特性
1、增加表格的默认列宽到120
2、表单保存后，支持单行刷
3、代码生成增加 splitValue 选项，默认 false
4、Result 增加用于指示前端如何提示信息的控制(需要重新生成代码): result.messageLevel4Notify()、result.messageLevel4Read()、result.messageLevel4Confirm()
5、适配达梦数据库，其它优化

### Bug 修复
1、已知 bug 修复
2、文件上传组件在禁用模式下可下载已经上传的文件




























## 版本：0.8.0.RELEASE ( 2022-01-20 )  Foxnic Version: 1.4.8.RELEASE
### 新特性
1. 优化打包，缩减打包的尺寸
2. 调整 storage 配置项的位置
3. 表格列自定义配置
4. Entity 增加 owner 属性
5. 主键包含多个列时代码生成的支持


### Bug 修复
1. 登录时，未关联员工异常修复
2. toast 组件图层问题
3. 调整代码生成时 fillWith 的处理方式，使用 return 替代异常，实现表单填充
4. 修复字典或枚举名值转换是未匹配导致的无限调用
5. 修复枚举值为数字时的bug
6. 修复 Job 项目中 Proxy 调用异常的问题















## 版本：0.7.0.RELEASE ( 2022-01-04 )  Foxnic Version: 1.4.6.RELEASE
### 新特性
1. 增加任务调度模块支持
2. 代码生成自动识别某些无法排序的字段
3. Job 增加 enable 参数和  force-run-job-ids 参数
4. Job 模块增加 Cron 示例与模拟校验功能
5. 增加接口调用的日志输出

### Bug 修复
1. 优化组织、人员取数接口调用的时机
2. 查询的数据表未定义时，输出异常日志，方便定位问题
3. 当表单有多个分组，title 都是 null 时，边距错误
4. 修复序列在日期切换时还有残余序号的问题
5. 优化因为加入 Job 而引起的启动耗时问题
6. 修复兼岗显示问题
7. 修复代码生成不支持支持 LogicSwitch 和 RadioBox 的关联搜索的问题
8. 数据库在 windows 下 MySQL 排序异常的 bug 处理。
9. 修复简单审批时审批人判断错误的 bug。



























## 版本：0.6.5.RELEASE ( 2021-11-29 )  Foxnic Version: 1.4.5.RELEASE
### 新特性
1. 解决前端高CPU问题的Bug
2. 表单窗口取消按钮失灵的Bug
3. 前后端 Token 传递优化
4. 上传组件优化以及在 ext.js 中增加事件回调
5. 增加任务调度模块
6. 表格列勾选后的记忆功能



### Bug 修复
1. 优化Druid 以及 MySQL 驱动
2. 修复多表 join 搜索时存在表别名未指定的 bug

















## 版本：0.6.2.RELEASE ( 2021-11-29 )  Foxnic Version: 1.4.2.RELEASE
### 新特性

1. 系统配置 Profile 支持，功能升级
2. 主题支持
3. 组织管理
4. 人员管理
5. 首页头像固定的问题
6. 优化和增强 Service 的 checkExists 方法
7. 代码生成在 search 上支持 triggerOnSelect ，针对某些需要选择的组件，是否在选择后立即触发查询
8. 针对日期查询 查询匹配模式 matchType，日期查询指定 day 后，后端自行处理日期值， 例如 查询指定日期范围  2021-12-10 ~ 2021-12-15 那么生成的语句是  birthday >= 2021-12-10 AND birthday <  2021-12-16
9. 代码生成：针对表单页面的嵌入部分增加ID值
10. 自定义表格分页挡
11. 排除不必要的 log4j 依赖
12. 扩展并优化图标选择


### Bug 修复
1. 账户管理无法按姓名查询的bug修复
2. 字典无法批量删除
3. 唯一键处理的无限循环bug
4. 修复枚举为code 为0时存在bug
5. 创建时间等默认字段无法生成到查询条件界面
6. PCM bug修复
7. 遗漏的主题支持
8. 修复下拉框宽度未对齐的问题，以及其它搜索区域对齐的优化
9. 修复下载成功后的回调Bug
10. 修复新建员工时岗位保存错误的问题
11. 验证码逻辑优化
12. 增加数据权限环境变量注入机制
13. token 未正确传递的 bug
14. 其它优化与修复


















## 版本：0.6.1.RELEASE ( 2021-11-29 )  Foxnic Version: 1.4.1.RELEASE
### 新特性

1. 代码生成: switch 组件默认居中 (done)
2. 代码生成: select 增加原始数据 , data 属性 (done)
3. 代码生成: select 增加 onSelectBoxChange 事件支持 (done)
4. ext.js 的 form.beforeInit 方法传入表单模式和数据 beforeInit(action,data)
5. 表单 model 增加 action 参数
6. 二级缓存使用redis channel 同步本地缓存数据
7. 插入或更新数据失败时，后端输出异常日志


### Bug 修复
1. VO Proxy 生成的代码未覆盖 Po 的 set 方法 (done)
2. 代码生成: 关系保存代码生成的问题处理  (done)

