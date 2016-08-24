package com.sorrer.utils.gui;

import java.util.LinkedList;

import com.sorrer.utils.Text;

public class DialogBox {
	
	private int step = -1;
	private LinkedList<String> lines;
	private int maxLines = 4;
	
	public DialogBox(LinkedList<String> lines){
		this.lines = lines;
	}
	/**
	 * Tests if stepping is still possible.
	 * If it is possible return true and add one to step;
	 * @return Is there a next line?
	 */
	public boolean next(){
		if(step < lines.size()){
			step++;
			return true;
		}
		return false;
	}
	
	/**
	 * Test if stepping is still possible.
	 * @return Is there a next line?
	 */
	public boolean isMore(){
		if(step < lines.size()){
			return true;
		}
		return false;
	}
	
	/**
	 * See if the current step is before the first position;
	 * @return boolean
	 */
	public boolean isBeforeFirst(){
		if(step == -1) return true;
		return false;
	}
	
	/**
	 * Grabs and returns current line step is on.
	 * Returns an empty string if not possible.
	 * @return Current line
	 */
	public String getLine(){
		if(step < lines.size()){
			return lines.get(step);
		}else{
			return "";
		}
	}
	/**
	 * @return Number of lines
	 */
	public int getSize(){
		return this.lines.size();
	}
	
	/**
	 * Resets step count to before first.
	 */
	public void reset(){
		step = -1;
	}
	
	/**
	 * Resets step count to first;
	 */
	
	public void resetFirst(){
		step = 0;
	}
	
	/**
	 * Sets the dialog, and resets the current step count to before first.
	 * @param lines List of dialog lines
	 */
	public void setLines(LinkedList<String> lines){
		this.lines = lines;
		reset();
	}
	
	/**
	 * Get dialog lines that are related to the current box of dialogs(cur - maxLines through cur).
	 */
	public LinkedList<String> getUILines(){
		LinkedList<String> dialog = new LinkedList<String>();
		this.step -= this.maxLines;
		for(int i = 0 ; i < this.maxLines; i++){
			if(next() && !(step < 0)){
				dialog.add(getLine());
			}
		}
		return dialog;
		
	}
	/**
	 * Adjusts the dialog to fit into the region defined
	 * @param text
	 * @param width
	 * @param height
	 */
	public void readjustLines(Text text, float width, float height){
		String combined = "";
		for(String l : this.lines){
			combined += l + " ";
		}
		
		this.lines.clear();
		int i = 0;
		while(combined.length() > 0){
			if(text.getStringLength(combined.substring(0, i)) >= width){
				String subbed = combined.substring(0, i);
				combined.replace(subbed, "");
				this.lines.add(subbed);
				i = 0;
			}else{
				i++;
			}
		}
		this.maxLines = 0;
		for(String l : this.lines){
			int max = 0;
			while(max * text.getStringHeight(l) < height){
				max++;
			}
			if(max > this.maxLines){
				this.maxLines = max;
			}
		}
	}
	
	/**
	 * Removes lines out of memory
	 */
	public void disposeLines(){
		this.lines = null;
	}
	
}
