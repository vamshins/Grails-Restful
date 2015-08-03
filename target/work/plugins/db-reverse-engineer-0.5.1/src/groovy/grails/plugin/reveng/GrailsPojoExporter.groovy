/* Copyright 2010-2014 SpringSource.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.plugin.reveng

import org.hibernate.tool.hbm2x.Cfg2HbmTool
import org.hibernate.tool.hbm2x.Cfg2JavaTool
import org.hibernate.tool.hbm2x.POJOExporter
import org.hibernate.tool.hbm2x.pojo.POJOClass

/**
 * Customizes the artifact name and source template, and customizes the tools.
 *
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
class GrailsPojoExporter extends POJOExporter {

	protected Cfg2HbmTool c2h
	protected GrailsCfg2JavaTool c2j
	protected boolean overwrite
	protected ConfigObject revengConfig

	GrailsPojoExporter(boolean overwrite, ConfigObject revengConfig) {
		this.overwrite = overwrite
		c2h = new Cfg2HbmTool()
		c2j = new GrailsCfg2JavaTool(c2h, getConfiguration(), revengConfig)
	}

	@Override
	protected void init() {
		setTemplateName getClass().getPackage().name.replace('.', '/') + '/DomainClass.ftl'
    	setFilePattern '{package-name}/{class-name}.groovy'
	}

	@Override
	Cfg2HbmTool getCfg2HbmTool() { c2h }

	@Override
	Cfg2JavaTool getCfg2JavaTool() { c2j }

	@Override
	protected void exportPOJO(Map additionalContext, POJOClass element) {
		GrailsTemplateProducer producer = new GrailsTemplateProducer(
			getTemplateHelper(), getArtifactCollector(), overwrite)
		additionalContext.pojo = element
		additionalContext.clazz = element.decoratedObject
		String filename = resolveFilename(element)
		producer.produce additionalContext, getTemplateName(),
			new File(getOutputDirectory(), filename),
			templateName, element.toString()
	}
}
