package org.encryfoundation.prismPlugin.builders

import java.io.File
import java.util.regex
import java.util.regex.{Matcher, Pattern}

import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.util.text.StringUtil
import com.intellij.openapi.vfs.VfsUtilCore
import org.jetbrains.annotations.NotNull
import org.jetbrains.jps.incremental.messages.CompilerMessage
import org.jetbrains.jps.incremental.messages.BuildMessage

import scala.util.matching.Regex

class PrismError {

  @NotNull
  def createCompilerMessage(@NotNull builderName: String,@NotNull compileTargetRootPath: String,@NotNull text: String): CompilerMessage = {
    println("createCompilerMessage: " + text)
    var kind: BuildMessage.Kind = BuildMessage.Kind.INFO
    var messageText: String = text
    var line: Long = -1L
    val error: (String, Int, BuildMessage.Kind) = create(compileTargetRootPath, text)
    if (error != null) {
      kind = error._3
      messageText = error._1
      line = error._2
    }
    println("error")
    println("err " + create(compileTargetRootPath, text))
    val c = new CompilerMessage(builderName, kind, messageText)
    println("createCompilerMessage111: " + c)
    c
  }

  val pattern: Pattern = Pattern.compile("^((?:[a-zA-Z]:)?.+?):(?:(\\d+):)?(\\s*Warning:)?\\s*(.+)$")

  val PATH_MATCH_INDEX: Int = 1
  val LINE_MATCH_INDEX: Int = 2
  val WARNING_MATCH_INDEX: Int = 3
  val DETAILS_MATCH_INDEX: Int = 4

  @NotNull
  def create(@NotNull rootPath: String,
             @NotNull prismcMsg: String)= {

    println("Create")
    println("prismMSG: " + prismcMsg)

    val matcher: Matcher = pattern.matcher(StringUtil.trimTrailing(prismcMsg))

    val msg = "Exception in thread \"main\" java.lang.Exception: Parsing failed: (test | comparison | arithExpr | lambdef | funcdef | constdef | ifLetExpr | ifExpr | block):1:15 ...\"{\\nlet erge"


    println("matcher: " + matcher)
    println(matcher.matches())
//    val relativeFilePath = FileUtil.toSystemIndependentName(matcher.group(PATH_MATCH_INDEX))
//    println("relativeFilePath")
//    val path = if (StringUtil.isEmpty(rootPath)) new File(relativeFilePath)
//    else new File(FileUtil.toSystemIndependentName(rootPath), relativeFilePath)
    println("path")

//    val line = pattern.group(LINE_MATCH_INDEX)
    println("line: " )
    val warning: String = matcher.group(WARNING_MATCH_INDEX)
    println("warning: " + warning)
    val details: String = matcher.group(DETAILS_MATCH_INDEX)
    println("details: " + details)
    createCompilerError("2", warning, details)

  }
@NotNull
  def createCompilerError( line: String,
                           warning: String,
                          @NotNull details: String) = {
  println("createCompilerError: " )
    val lineNumber = StringUtil.parseInt(line.toString, -1)
    val category = if (warning != null) BuildMessage.Kind.WARNING
    else BuildMessage.Kind.ERROR
    (details, lineNumber, category)
  }

}
