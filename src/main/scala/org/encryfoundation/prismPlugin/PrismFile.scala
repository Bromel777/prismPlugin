package org.encryfoundation.prismPlugin

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

case class PrismFile(viewProvider: FileViewProvider) extends PsiFileBase(viewProvider, PrismLanguage.INSTANCE) {

  override def getFileType: FileType = PrismFileType.INSTANCE
}