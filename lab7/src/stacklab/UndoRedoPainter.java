package stacklab;

import java.util.*;

public class UndoRedoPainter extends Painter {
	UndoRedoPainter() {
		this.setUndoButtonEnabled(false);
		this.setRedoButtonEnabled(false);
	}

	// Called when the user pushes the Undo button.
	void undo() {
		Stack<Circle> hist = this.getHistory();
		Stack<Circle> undoHist = this.getUndoHistory();
		if (!hist.isEmpty()) {
			Circle top = hist.pop();
			undoHist.add(top);
		}
		if (this.getHistory().isEmpty() && !this.getUndoHistory().isEmpty()) {
			this.setUndoButtonEnabled(false);
			this.setRedoButtonEnabled(true);
		}
		this.repaint();
	}

	// Called when the user pushes the Redo button.
	void redo() {
		Stack<Circle> undoHist = this.getUndoHistory();
		Stack<Circle> hist = this.getHistory();
		if (!undoHist.isEmpty()) {
			Circle redo = undoHist.pop();
			hist.add(redo);
		}
		if (!this.getHistory().isEmpty() && this.getUndoHistory().isEmpty()) {
			this.setRedoButtonEnabled(false);
			this.setUndoButtonEnabled(true);
		}
		this.repaint();
	}

	public static void main(String[] args) {
		new UndoRedoPainter().setVisible(true);
	}
}
