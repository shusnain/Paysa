package com.example.android.paysa;

import android.nfc.Tag;
import android.util.Log;

import com.example.android.paysa.domain.models.Job;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import static android.content.ContentValues.TAG;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void job_ThrowsException() throws Exception{
        Date startDate = new GregorianCalendar(2017, Calendar.JANUARY, 1).getTime();
        Date endDate = new GregorianCalendar(2017, Calendar.JANUARY, 2).getTime();
        try{
            Job a = new Job("1", "1", 1, endDate, startDate);
            fail("Expected an exception to be thrown");
        }catch(Exception e){
            assertEquals(e.getMessage(), "startDate is after endDate");
        }
    }
}