package org.encryfoundation.prismPlugin.editor

import java.util

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.{AttributesDescriptor, ColorDescriptor, ColorSettingsPage}
import javax.swing.Icon

class PrismColorSettingPage extends ColorSettingsPage {

  override def getIcon: Icon = ???

  override def getHighlighter: SyntaxHighlighter = ???

  override def getDemoText: String = ???

  override def getAdditionalHighlightingTagToDescriptorMap: util.Map[String, TextAttributesKey] = ???

  override def getAttributeDescriptors: Array[AttributesDescriptor] = ???

  override def getColorDescriptors: Array[ColorDescriptor] = ???

  override def getDisplayName: String = ???
}
