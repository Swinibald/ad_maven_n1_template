/*
 * Copyright 2025 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.exercise.n1.joins;

import org.slf4j.LoggerFactory;

import ch.hslu.ad.exercise.n1.bank.AccountTask;

import org.slf4j.Logger;

/**
 * Demonstration von Join und Sleep - Aufgabe 3 - N1_EX_ThreadsSynch.
 */
public final class JoinAndSleep {
    
    private static final Logger LOG = LoggerFactory.getLogger(JoinAndSleep.class);

    /**
     * Privater Konstruktor.
     */
    private JoinAndSleep() {
    }
    
    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException wenn Warten unterbrochen wird.
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t3 = new Thread(new JoinAndSleepTask("Thread3", 4000, null), "Thread3"); 
        Thread t2 = new Thread(new JoinAndSleepTask("Thread2", 3000, t3), "Thread2"); 
        Thread t1 = new Thread(new JoinAndSleepTask("Thread1", 2000,t2),"Thread1"); 
        LOG.info("Start von Thread3");
        t3.start();
        LOG.info("Start von Thread2");
        t2.start();
        LOG.info("Start von Thread1");
        t1.start();

        // t2 unterbrechen zum Testen der Exception
        //t2.interrupt();
    }
}
