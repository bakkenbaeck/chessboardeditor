package no.bakkenbaeck.chessboardeditor.model

class FenParseException : Exception {

    var pos: Position? = null
    var resourceId = -1

    constructor(msg: String) : super(msg) {
        pos = null
    }

    constructor(msg: String, pos: Position) : super(msg) {
        this.pos = pos
    }

    constructor(resourceId: Int) : super("") {
        pos = null
        this.resourceId = resourceId
    }

    constructor(resourceId: Int, pos: Position) : super("") {
        this.pos = pos
        this.resourceId = resourceId
    }

    companion object {
        private val serialVersionUID = -6051856171275301175L
    }
}
