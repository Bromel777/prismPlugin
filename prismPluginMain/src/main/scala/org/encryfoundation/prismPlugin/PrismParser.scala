package org.encryfoundation.prismPlugin

import java.io.Reader

import com.intellij.lang.{ASTNode, ParserDefinition, PsiParser}
import com.intellij.lexer.{FlexAdapter, Lexer}
import com.intellij.openapi.project.Project
import com.intellij.psi.{FileViewProvider, PsiElement, PsiFile}
import com.intellij.psi.tree.{IFileElementType, TokenSet}
import com.intellij.psi.TokenType
import org.encryfoundation.prismPlugin.lexer._GeneratedLexer
import org.encryfoundation.prismPlugin.psi.{PrismTokenType, PrismTypes}

class PrismParser extends ParserDefinition {

  val white_spaces: TokenSet = TokenSet.create(TokenType.WHITE_SPACE)

  val comment: PrismTokenType = new PrismTokenType("Comment")

  val comments: TokenSet = TokenSet.create(comment)

  val file: IFileElementType = new IFileElementType(PrismLanguage.INSTANCE)

  override def createLexer(project: Project): Lexer = new FlexAdapter(new _GeneratedLexer(null.asInstanceOf[Reader]))

  override def createParser(project: Project): PsiParser = new GeneratedParser()

  override def getFileNodeType: IFileElementType = file

  override def getCommentTokens: TokenSet = comments

  override def getStringLiteralElements: TokenSet = TokenSet.EMPTY

  override def createElement(astNode: ASTNode): PsiElement = PrismTypes.Factory.createElement(astNode)

  override def createFile(fileViewProvider: FileViewProvider): PsiFile = PrismFile(fileViewProvider)
}
