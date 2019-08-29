package org.encryfoundation.prismPlugin

import com.intellij.lang.Language

object PrismLanguage {
  lazy val INSTANCE = new PrismLanguage
}

class PrismLanguage extends Language("Prism")