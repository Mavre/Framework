package com.epam.reutska.helpers.core;



import java.io.IOException;

public interface IReader{
	

	Object [][] read(int sheetNumber) throws IOException;
}
