**《SpringBoot 整合 Spring Data JPA 实现数据库操作的项目》** 

最近在学习Spring Data JPA的相关知识,感觉还是很不错的,提供了很多方法,包括CRUD和分页排序,基本能够满足现实的功能需求.
它一共提供了四个接口:
 Repository： 仅仅是一个标识，表明任何继承它的均为仓库接口类，方便Spring自动扫描识别 
 CrudRepository： 继承Repository，实现了一组CRUD相关的方法 
 PagingAndSortingRepository： 继承CrudRepository，实现了一组分页排序相关的方法 
 JpaRepository： 继承PagingAndSortingRepository，实现一组JPA规范相关的方法 
 JpaSpecificationExecutor： 比较特殊，不属于Repository体系，实现一组JPA Criteria查询相关的方法