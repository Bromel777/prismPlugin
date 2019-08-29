package org.encryfoundation.prismPlugin

import com.intellij.openapi.fileTypes.{FileTypeConsumer, FileTypeFactory}

class PrismFileTypeFactory extends FileTypeFactory {

  override def createFileTypes(fileTypeConsumer: FileTypeConsumer): Unit =
    fileTypeConsumer.consume(PrismFileType.INSTANCE, "pr")
}
