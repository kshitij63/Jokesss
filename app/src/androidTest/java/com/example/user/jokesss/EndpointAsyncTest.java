package com.example.user.jokesss;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by user on 6/22/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndpointAsyncTest implements Response {
    private CountDownLatch latch;
    private String joke;

    @Test
    public void testGetJokeAsyncTask() throws Throwable {
        latch = new CountDownLatch(1);
        EndpointAsyncTask endPointAsyncTask = new EndpointAsyncTask();
        endPointAsyncTask.mediateResponse = this;
        endPointAsyncTask.execute();
        latch.await(10, TimeUnit.SECONDS);
        assertNotNull("joke is null", joke);
        assertFalse("joke is empty", joke.isEmpty());
    }


    @Override
    public void finished(String joke) {
        this.joke = joke;
        latch.countDown();

    }
}
