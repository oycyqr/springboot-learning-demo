package com.oycbest.springboothutools.demo;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.URLUtil;

/**
 * @Author: oyc
 * @Date: 2020-04-26 14:38
 * @Description:
 */
public class TestURLUtil {
	public static void main(String[] args) {
		// URLUtil.normalize 标准化化URL链接。对于不带http://头的地址做简单补全。
		String url = "http://www.hutool.cn//aaa/bbb";
		// 结果为：http://www.hutool.cn/aaa/bbb
		String normalize = URLUtil.normalize(url);
		System.out.println(normalize);

		url = "http://www.hutool.cn//aaa/\\bbb?a=1&b=2";
		// 结果为：http://www.hutool.cn/aaa/bbb?a=1&b=2
		normalize = URLUtil.normalize(url);
		System.out.println(normalize);

		//URLUtil.encode 封装URLEncoder.encode，将需要转换的内容（ASCII码形式之外的内容），用十六进制表示法转换出来，并在之前加上%开头。
		String body = "366466 - 副本.jpg";
		// 结果为：366466%20-%20%E5%89%AF%E6%9C%AC.jpg
		normalize = URLUtil.encode(body);
		System.out.println(normalize);


		//UUID全称通用唯一识别码（universally unique identifier），JDK通过java.util.UUID提供了 Leach-Salz 变体的封装。在Hutool中，生成一个UUID字符串方法如下：

		//生成的UUID是带-的字符串，类似于：a5c8a5e8-df2b-4706-bea4-08d0939410e3
		String uuid = IdUtil.randomUUID();
		System.out.println(uuid);

		//生成的是不带-的字符串，类似于：b17f24ff026d40949c85a24f4f375d42
		String simpleUUID = IdUtil.simpleUUID();
		System.out.println(simpleUUID);

		//ObjectId是MongoDB数据库的一种唯一ID生成策略，是UUID version1的变种，详细介绍可见：服务化框架－分布式Unique ID的生成方法一览。
		//生成类似：5b9e306a4df4f8c54a39fb0c
		String id = ObjectId.next();
		//方法2：从Hutool-4.1.14开始提供
		String id1 = IdUtil.objectId();
		System.out.println(id);
		System.out.println(id1);

//Snowflake分布式系统中，有一些需要使用全局唯一ID的场景，有些时候我们希望能使用一种简单一些的ID，并且希望ID能够按照时间有序生成。Twitter的Snowflake 算法就是这种生成器。
		//参数1为终端ID
//参数2为数据中心ID
		Snowflake snowflake = IdUtil.createSnowflake(1, 1);
		long id2 = snowflake.nextId();
		System.out.println(id2);
		String a = null;
		Assert.notNull(a);

		System.out.println(123);
	}
}
