package org.encryfoundation.prismPlugin.editor

import java.util
import scala.collection.JavaConverters._
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.{AttributesDescriptor, ColorDescriptor, ColorSettingsPage}
import javax.swing.Icon
import org.encryfoundation.prismPlugin.Icons
import org.encryfoundation.prismPlugin.syntax.PrismSyntaxHighlighter
import org.encryfoundation.prismPlugin.syntax.PrismSyntaxHighlighter._

class PrismColorSettingPage extends ColorSettingsPage {

  override def getIcon: Icon = Icons.prismLogo

  override def getHighlighter: SyntaxHighlighter = PrismSyntaxHighlighter()

  override def getDemoText: String = ""

  override def getAdditionalHighlightingTagToDescriptorMap: util.Map[String, TextAttributesKey] =
    Map.empty[String, TextAttributesKey].asJava

  override def getAttributeDescriptors: Array[AttributesDescriptor] = Array(
    new AttributesDescriptor("Illegal character", ILLEGAL),
    new AttributesDescriptor("String", STRING),
    new AttributesDescriptor("Identifier", ID),
    new AttributesDescriptor("Number", NUMBER),
    new AttributesDescriptor("Bracket", BRACKETS),
    new AttributesDescriptor("Keyword", KEYWORD),
    new AttributesDescriptor("Types", TYPE_ATTR)
  )

  override def getColorDescriptors: Array[ColorDescriptor] = ColorDescriptor.EMPTY_ARRAY

  override def getDisplayName: String = "Prism"
}
