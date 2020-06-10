package com.oycbest.ssmblog.vo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: oyc
 * @Date: 2020-06-05 9:48
 * @Description: http json结果集
 */
public class Result implements Serializable {

	/**
	 * 定义jackson对象
	 */
	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 响应业务状态
	 */
	private Integer status;

	/**
	 * 响应消息
	 */
	private String msg;
	/**
	 * 响应中的数据
	 */
	private Object data;

	public static Result build(Integer status, String msg, Object data) {
		return new Result(status, msg, data);
	}

	public static Result ok(Object data) {
		return new Result(data);
	}

	public static Result ok() {
		return new Result(null);
	}
	public static Result unAuth() {
		return new Result(401,"请先登录","");
	}
	public static Result error(String msg) {
		return new Result(500,msg,"");
	}
	public Result() {
	}

	public static Result build(Integer status, String msg) {
		return new Result(status, msg, null);
	}

	public Result(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public Result(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 将json结果集转化为Result对象
	 *
	 * @param jsonData json数据 传的是Result的对象的Json字符串
	 * @param clazz    TaotaoResult中的object类型
	 * @return
	 */
	public static Result formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if (clazz == null) {
				return MAPPER.readValue(jsonData, Result.class);
			}
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (clazz != null) {
				if (data.isObject()) {
					obj = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {
					obj = MAPPER.readValue(data.asText(), clazz);
				}
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 没有object对象的转化
	 *
	 * @param json
	 * @return
	 */
	public static Result format(String json) {
		try {
			return MAPPER.readValue(json, Result.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Object是集合转化
	 *
	 * @param jsonData 传的是Result的对象的Json字符串
	 *                 json数据
	 * @param clazz    集合中的类型
	 * @return
	 */
	public static Result formatToList(String jsonData, Class<?> clazz) {
		try {
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object obj = null;
			if (data.isArray() && data.size() > 0) {
				obj = MAPPER.readValue(data.traverse(),
						MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Result{" +
				"status=" + status +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}

