
|比较	|List	|Set	|Map|
|-	|-	|-	|-|
|继承接口|	Collection|	Collection	|-|
|常见实现类|	AbstractList(其常用子类有ArrayList、LinkedList、Vector)|	AbstractSet(其常用子类有HashSet、LinkedHashSet、TreeSet)	|HashMap、HashTable|
|常见方法|	add( )、remove( )、clear( )、get( )、contains( )、size( )|	add( )、remove( )、clear( )、contains( )、size( )|	put( )、get( )、remove( )、clear( )、containsKey( )、containsValue( )、keySet( )、values( )、size( )|
|元素|	可重复 |	不可重复(用equals()判断)|	不可重复|
|顺序|	有序 |	无序(实际上由HashCode决定)	|-|
|线程安全|	Vector线程安全	|-|	Hashtable线程安全|

利用Collections.syschronizedXX方法，获取线程安全的集合：
1. synchronizedCollection: 返回指定 collection 支持的同步（线程安全的）collection。
2. synchronizedList: 返回指定列表支持的同步（线程安全的）列表。
3. synchronizedMap: 返回由指定映射支持的同步（线程安全的）映射。
4. synchronizedSet: 返回指定 set 支持的同步（线程安全的）set。
5. synchronizedSortedMap: 返回指定有序映射支持的同步（线程安全的）有序映射。
6. synchronizedSortedSet: 返回指定有序 set 支持的同步（线程安全的）有序 set。
