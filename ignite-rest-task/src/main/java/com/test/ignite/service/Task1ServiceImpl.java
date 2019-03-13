package com.test.ignite.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteQueue;
import org.apache.ignite.resources.IgniteInstanceResource;
import org.apache.ignite.services.Service;
import org.apache.ignite.services.ServiceContext;

import com.test.ignite.task.Task1;

public class Task1ServiceImpl implements Service{
	
	@IgniteInstanceResource
	private Ignite ignite;

	/** Distributed cache used to store counters. */
	private IgniteCache<String, Integer> cache;

	private IgniteQueue<String> queue;
	
	@Override
	public void cancel(ServiceContext ctx) {
		System.out.println(".....inside Task1ServiceImpl cancel()");
		
	}

	@Override
	public void init(ServiceContext ctx) throws Exception {
		System.out.println(".....inside Task1ServiceImpl init()");
		ignite.compute().localDeployTask(Task1.class, this.getClass().getClassLoader());
		
	}

	@Override
	public void execute(ServiceContext ctx) throws Exception {
		System.out.println(".....inside Task1ServiceImpl execute()");
		
	}

}
