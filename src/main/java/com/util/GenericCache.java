package com.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public abstract class GenericCache<M, R> {
	
	public LoadingCache<M,R> cache = CacheBuilder.newBuilder()
	           .maximumSize(1000)
	           .expireAfterAccess(10, TimeUnit.MINUTES)
	           .recordStats()
	           .build(new CacheLoader<M, R>() {

	               @Override
	               public R load(M model) throws Exception {
	                   return send1(model);
	               }
	           });

	public LoadingCache<M,List<R>> cacheList = CacheBuilder.newBuilder()
	           .maximumSize(1000)
	           .expireAfterAccess(10, TimeUnit.MINUTES)
	           .recordStats()
	           .build(new CacheLoader<M, List<R>>() {

	               @Override
	               public List<R> load(M model) throws Exception {
	                   return send2();
	               }
	           });
	
	//factory methods
	public abstract R send1(M model);
	public abstract List<R> send2();

}
