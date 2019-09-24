# Chess Board Editor
A component that allows you to freely place and move pieces on a chess board.

### To include this library in your project:

[![Release](https://jitpack.io/v/bakkenbaeck/chessboardeditor.svg)](https://jitpack.io/#bakkenbaeck/chessboardeditor)


Step 1 - Add the JitPack repository to your root build.gradle, at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2 - Add the dependency to your sub build.gradle:

	dependencies {
	        implementation 'com.github.bakkenbaeck:chessboardeditor:v1.0.2'
	}
  
### How to use:

Currently the board view can be initialized with any valid FEN string using the `ChessBoardView::setFen()` method. Call the `ChessBoardView::getFen()` method anytime to return the current board setup in FEN representation ([more info on FEN](https://en.wikipedia.org/wiki/Forsyth–Edwards_Notation)).

Here's an example on how to load a chess board with the default starting setup:

Step 1 - Add this layout to your xml layout file:

```
<no.bakkenbaeck.chessboardeditor.view.board.ChessBoardView
            android:id="@+id/chessBoard"
            .../>
```

Step 2 - Call `ChessBoardView::setFen()` in `onViewCreated` (if using fragments):

```
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
	...
        chessBoard.setFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1")
    }
```

Step 3 - Call `ChessBoardView::getFen()` whenever required:

```
    val fen = chessBoard.getFen()
```

  
### Demo:

![Demo](https://media.giphy.com/media/f8sQ4jIdt9wQz8Gg1s/giphy.gif)
