package org.encryfoundation.prismPlugin

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

case class PrismFileType() extends LanguageFileType(PrismLanguage.INSTANCE) {

  override def getName: String = "Prism Contract"

  override def getDescription: String = "Prism language file"

  override def getDefaultExtension: String = "pr"

  override def getIcon: Icon = Icons.prismLogo
}

object PrismFileType {

  lazy val INSTANCE = new PrismFileType()
}
