package org.encryfoundation.prismPlugin.syntax

import com.intellij.openapi.fileTypes.{SyntaxHighlighter, SyntaxHighlighterFactory}
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class PrismSyntaxHighlighterFactory extends SyntaxHighlighterFactory {

  override def getSyntaxHighlighter(project: Project,
                                    virtualFile: VirtualFile): SyntaxHighlighter = PrismSyntaxHighlighter()
}
