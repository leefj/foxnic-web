package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.Node;
import java.util.Date;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-13 22:40:35
 * @sign 0BB6D9F3A2F3AA3F012C793657D0F747
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class NodeMeta {
	
	/**
	 * 实例id , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 实例id , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,ID, java.lang.String.class, "实例id", "实例id", java.lang.String.class, null);
	
	/**
	 * 主机ID , 类型: java.lang.String
	*/
	public static final String HOST_ID="hostId";
	
	/**
	 * 主机ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.String> HOST_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,HOST_ID, java.lang.String.class, "主机ID", "主机ID", java.lang.String.class, null);
	
	/**
	 * 应用名称 , 类型: java.lang.String
	*/
	public static final String APPLICATION_NAME="applicationName";
	
	/**
	 * 应用名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.String> APPLICATION_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,APPLICATION_NAME, java.lang.String.class, "应用名称", "应用名称", java.lang.String.class, null);
	
	/**
	 * 端口 , 类型: java.lang.Integer
	*/
	public static final String PORT="port";
	
	/**
	 * 端口 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.Integer> PORT_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,PORT, java.lang.Integer.class, "端口", "端口", java.lang.Integer.class, null);
	
	/**
	 * 进程号 , 类型: java.lang.String
	*/
	public static final String PROCESS_ID="processId";
	
	/**
	 * 进程号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.String> PROCESS_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,PROCESS_ID, java.lang.String.class, "进程号", "进程号", java.lang.String.class, null);
	
	/**
	 * 启动时间 , 类型: java.util.Date
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 启动时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.util.Date> START_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,START_TIME, java.util.Date.class, "启动时间", "启动时间", java.util.Date.class, null);
	
	/**
	 * 是否启动 , 类型: java.lang.Integer
	*/
	public static final String IS_UP="isUp";
	
	/**
	 * 是否启动 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.Integer> IS_UP_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,IS_UP, java.lang.Integer.class, "是否启动", "是否启动", java.lang.Integer.class, null);
	
	/**
	 * 心跳时间 , 类型: java.util.Date
	*/
	public static final String HEART_BEAT_TIME="heartBeatTime";
	
	/**
	 * 心跳时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.util.Date> HEART_BEAT_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,HEART_BEAT_TIME, java.util.Date.class, "心跳时间", "心跳时间", java.util.Date.class, null);
	
	/**
	 * 主机名称 , 类型: java.lang.String
	*/
	public static final String HOST_NAME="hostName";
	
	/**
	 * 主机名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.String> HOST_NAME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,HOST_NAME, java.lang.String.class, "主机名称", "主机名称", java.lang.String.class, null);
	
	/**
	 * IP地址 , 类型: java.lang.String
	*/
	public static final String IP="ip";
	
	/**
	 * IP地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.String> IP_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,IP, java.lang.String.class, "IP地址", "IP地址", java.lang.String.class, null);
	
	/**
	 * 雪花DCId , 类型: java.lang.Integer
	*/
	public static final String DATACENTER_ID="datacenterId";
	
	/**
	 * 雪花DCId , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.Integer> DATACENTER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,DATACENTER_ID, java.lang.Integer.class, "雪花DCId", "雪花DCId", java.lang.Integer.class, null);
	
	/**
	 * 雪花WKId , 类型: java.lang.Integer
	*/
	public static final String WORKER_ID="workerId";
	
	/**
	 * 雪花WKId , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.Integer> WORKER_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,WORKER_ID, java.lang.Integer.class, "雪花WKId", "雪花WKId", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Node,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Node.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , HOST_ID , APPLICATION_NAME , PORT , PROCESS_ID , START_TIME , IS_UP , HEART_BEAT_TIME , HOST_NAME , IP , DATACENTER_ID , WORKER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.Node {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 实例id
		 * @param id 实例id
		 * @return 当前对象
		*/
		public Node setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 主机ID
		 * @param hostId 主机ID
		 * @return 当前对象
		*/
		public Node setHostId(String hostId) {
			super.change(HOST_ID,super.getHostId(),hostId);
			super.setHostId(hostId);
			return this;
		}
		
		/**
		 * 设置 应用名称
		 * @param applicationName 应用名称
		 * @return 当前对象
		*/
		public Node setApplicationName(String applicationName) {
			super.change(APPLICATION_NAME,super.getApplicationName(),applicationName);
			super.setApplicationName(applicationName);
			return this;
		}
		
		/**
		 * 设置 端口
		 * @param port 端口
		 * @return 当前对象
		*/
		public Node setPort(Integer port) {
			super.change(PORT,super.getPort(),port);
			super.setPort(port);
			return this;
		}
		
		/**
		 * 设置 进程号
		 * @param processId 进程号
		 * @return 当前对象
		*/
		public Node setProcessId(String processId) {
			super.change(PROCESS_ID,super.getProcessId(),processId);
			super.setProcessId(processId);
			return this;
		}
		
		/**
		 * 设置 启动时间
		 * @param startTime 启动时间
		 * @return 当前对象
		*/
		public Node setStartTime(Date startTime) {
			super.change(START_TIME,super.getStartTime(),startTime);
			super.setStartTime(startTime);
			return this;
		}
		
		/**
		 * 设置 是否启动
		 * @param isUp 是否启动
		 * @return 当前对象
		*/
		public Node setIsUp(Integer isUp) {
			super.change(IS_UP,super.getIsUp(),isUp);
			super.setIsUp(isUp);
			return this;
		}
		
		/**
		 * 设置 心跳时间
		 * @param heartBeatTime 心跳时间
		 * @return 当前对象
		*/
		public Node setHeartBeatTime(Date heartBeatTime) {
			super.change(HEART_BEAT_TIME,super.getHeartBeatTime(),heartBeatTime);
			super.setHeartBeatTime(heartBeatTime);
			return this;
		}
		
		/**
		 * 设置 主机名称
		 * @param hostName 主机名称
		 * @return 当前对象
		*/
		public Node setHostName(String hostName) {
			super.change(HOST_NAME,super.getHostName(),hostName);
			super.setHostName(hostName);
			return this;
		}
		
		/**
		 * 设置 IP地址
		 * @param ip IP地址
		 * @return 当前对象
		*/
		public Node setIp(String ip) {
			super.change(IP,super.getIp(),ip);
			super.setIp(ip);
			return this;
		}
		
		/**
		 * 设置 雪花DCId
		 * @param datacenterId 雪花DCId
		 * @return 当前对象
		*/
		public Node setDatacenterId(Integer datacenterId) {
			super.change(DATACENTER_ID,super.getDatacenterId(),datacenterId);
			super.setDatacenterId(datacenterId);
			return this;
		}
		
		/**
		 * 设置 雪花WKId
		 * @param workerId 雪花WKId
		 * @return 当前对象
		*/
		public Node setWorkerId(Integer workerId) {
			super.change(WORKER_ID,super.getWorkerId(),workerId);
			super.setWorkerId(workerId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Node setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Node setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Node setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Node setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Node setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Node setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Node setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Node setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}