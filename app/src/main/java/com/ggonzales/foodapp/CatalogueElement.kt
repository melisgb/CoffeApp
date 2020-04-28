package com.ggonzales.foodapp

class CatalogueElement{
    var name : String?= null
    var desc : String? = null
    var image : Int? = null
    constructor(name : String, desc : String, image : Int?  ){
        this.name = name
        this.desc = desc
        this.image = image
    }
}