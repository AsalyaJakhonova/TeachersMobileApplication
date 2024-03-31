package com.example.teachersapp

data class PdfFile(val fileName : String, val downloadUrl : String){
    constructor() : this ("","")
}
