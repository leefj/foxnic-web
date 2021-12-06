## 版本：0.6.2.RELEASE ( 2021-11-29 )  Foxnic Verdion: 1.4.2.RELEASE
### 新特性

1. 系统配置 Profile 支持，功能升级
2. 主题支持
3. 组织管理
4. 人员管理


### Bug 修复
1. 账户管理无法按姓名查询的bug修复
2. 字典无法批量删除

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

