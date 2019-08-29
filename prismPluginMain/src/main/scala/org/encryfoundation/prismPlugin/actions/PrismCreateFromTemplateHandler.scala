package org.encryfoundation.prismPlugin.actions

import java.util

import com.intellij.ide.fileTemplates.{DefaultCreateFromTemplateHandler, FileTemplate, FileTemplateManager}
import org.encryfoundation.prismPlugin.PrismFileType

class PrismCreateFromTemplateHandler extends DefaultCreateFromTemplateHandler {

  override def handlesTemplate(template: FileTemplate): Boolean = {
    println(s"handlesTemplate: ${template == FileTemplateManager.getDefaultInstance().getInternalTemplate("Prism Contract")}")
    println(s"Also: ${template.isTemplateOfType(PrismFileType.INSTANCE)}")
    template.isTemplateOfType(PrismFileType.INSTANCE)
  }

  override def prepareProperties(props: util.Map[String, AnyRef]): Unit = {
    println("prepareProperties")
    val name: String = props.get(FileTemplate.ATTRIBUTE_NAME).asInstanceOf[String]
    props.put(FileTemplate.ATTRIBUTE_NAME + "_PRISM", Character.toUpperCase(name.charAt(0)) + name.substring(1))
  }
}
