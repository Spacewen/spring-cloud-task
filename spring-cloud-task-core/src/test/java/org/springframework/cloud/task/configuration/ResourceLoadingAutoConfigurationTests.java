/*
 *  Copyright 2016 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.springframework.cloud.task.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.deployer.resource.maven.MavenProperties;
import org.springframework.cloud.deployer.resource.maven.MavenResourceLoader;
import org.springframework.cloud.deployer.resource.support.DelegatingResourceLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author Glenn Renfro
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ResourceLoadingAutoConfiguration.class})
public class ResourceLoadingAutoConfigurationTests {

	@Autowired
	ApplicationContext context;

	@Test
	public void testTaskLauncher() {
		MavenResourceLoader mavenResourceLoader =
				context.getBean(MavenResourceLoader.class);
		assertNotNull(mavenResourceLoader);

		DelegatingResourceLoader delegatingResourceLoader =
				context.getBean(DelegatingResourceLoader.class);
		assertNotNull(delegatingResourceLoader);

		MavenProperties mavenProperties =
				context.getBean(MavenProperties.class);
		assertNotNull(mavenProperties);
	}

}
