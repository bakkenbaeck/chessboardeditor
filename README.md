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
	        implementation 'com.github.bakkenbaeck:chessboardeditor:v1.0.0'
	}
  
### How to use:

Add this layout to your xml layout file:

```
<no.bakkenbaeck.chessboardeditor.view.board.ChessBoardView
            android:id="@+id/chessBoard"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
```

Use `ChessBoardView::getFen()` and `ChessBoardView::setFen` to initialize and read the edited board.
  
  
### Screenshot:
 
  <img src="https://user-images.githubusercontent.com/40384699/65425724-f1412e80-de0e-11e9-8522-f6336296aae4.png" width="400">
