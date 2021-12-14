## 版本：0.6.2.RELEASE ( 2021-11-29 )  Foxnic Verdion: 1.4.2.RELEASE
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
    

9. 其它优化与修复


















## 版本：0.6.1.RELEASE ( 2021-11-29 )  Foxnic Verdion: 1.4.1.RELEASE
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

