package com.jinwoo.portfolio.admin.data

abstract class FormElementDTO(
    val name: String,
    val size: Int,
    val type: String
)

class TextFormElementDTO(
    name: String,
    size: Int
) : FormElementDTO(name = name, size = size, type = "Text")

class DateFormElementDTO(
    name: String,
    size: Int
) : FormElementDTO(name = name, size = size, type = "Date")

class SelectFormElementDTO(
    name: String,
    size: Int,
    options: List<Any>
) : FormElementDTO(name = name, size = size, type = "Select") {
    val options: List<Any> = options

}