package maps;

import java.util.ArrayList;

public class Map<K,V> {
	
	ArrayList<MapNode<K,V>> buckets;
	int count,numBuckets;
	
	public Map() {
		buckets = new ArrayList<>();
		numBuckets = 20;
		for(int i =0;i<numBuckets;i++)
		{
			buckets.add(null);
		}
	}
	
	private int index(K key)
	{
		int hashcode = key.hashCode();
		int index = hashcode%numBuckets;
		return index;
	}
	
	public void insert(K key,V value)
	{
		int bucketIndex = index(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				head.value=value;
				return;
			}
			head=head.next;
		}
		
		head=buckets.get(bucketIndex);
		MapNode<K,V> newNode = new MapNode<>(key,value);
		newNode.next=head;
		buckets.set(bucketIndex, newNode);
		count++;
		
	}
	
	public int size()
	{
		return count;
	}
	
	public V getValue(K key)
	{
		int bucketIndex = index(key);
		
		MapNode<K,V> head = buckets.get(bucketIndex);
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				return head.value;
			}
				
			head=head.next;
		}
		return null;
			
	}
	
	public V removeKey(K key)
	{
		int bucketIndex = index(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		MapNode<K,V> prev = null;
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				if(prev!=null)
				{
				prev.next=head.next;
				return head.value;
				}
				else
				{
					buckets.set(bucketIndex, head.next);
				}
			}
			prev=head;
			head=head.next;
		}
		return null;
	}

}
