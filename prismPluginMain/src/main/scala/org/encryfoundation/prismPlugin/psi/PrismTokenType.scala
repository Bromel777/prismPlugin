package org.encryfoundation.prismPlugin.psi

import com.intellij.psi.tree.IElementType
import org.encryfoundation.prismPlugin.PrismLanguage

class PrismTokenType(debugName: String) extends IElementType(debugName, PrismLanguage.INSTANCE)
