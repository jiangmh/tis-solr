/* 
 * The MIT License
 *
 * Copyright (c) 2018-2022, qinglangtech Ltd
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.qlangtech.tis.realtime;

import com.qlangtech.tis.realtime.yarn.TransferIncrContainer;
import org.apache.hadoop.security.UserGroupInformation;
import java.util.Arrays;
import java.util.List;

/* 
 * 增量工程启动类
 * @author 百岁（baisui@qlangtech.com）
 * @date 2019年1月17日
 */
public class TisIncrLauncher {

	private static final String APP_NAME = "transferApp";
	public static final String PARAM_OPTION_LOCAL_JAR_DIR = "localjardir";
	public static final String PARAM_OPTION_LOCAL_QUEUE = "queue";
	public static final String ENVIRONMENT_INCR_EXEC_GROUP = "incr_exec_group";

	public static void main(String[] args) throws Exception {
		UserGroupInformation.setLoginUser(UserGroupInformation.createRemoteUser("Tis"));
		List<String> argsList = Arrays.asList(args);
		System.out.println("args: " + argsList.toString());
		TransferIncrContainer incrContainer = new TransferIncrContainer(argsList);
		incrContainer.start();
	}
}
