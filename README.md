# EMS员工管理系统

> 主要是梳理逻辑和实现思路核心时service层，所以其他代码细节(包括测试部分)并不完善
> 本系统修改对象不需要在service实现主要是由于，修改时其实时获取对象然后通过修改器修改属性

### 基于数组实现: ems-array
- 主要涉及知识点
  - 类和对象
  - 类的封装
  - 对象数组以及数组的插入删除
  - 聚合
  - 多态
#### 需求说明
模拟实现基于文本界面的《员工管理系统》
能够实现员工对象的插入、修改和删除操作，能够打印员工明细表以及退出
- 每个员工信息被保存在Employee对象中
- 员工信息包括：编号、姓名、年龄、工资
- 员工有职位的不同：架构师、设计师、程序员和普通员工
- 有的员工有奖金(bouns)和股票(stock), 普通员工和程序员只有工资，架构师有奖金和股票，设计师有奖金
- 公司对于开发人员组成要求：最多两名架构师，最多三名设计师和最多五名程序员

#### 设计结构
软件由四个模块构成：
- com.djn.ems.view: 视图层
  - EmployeeView: 菜单显示和处理用户操作
- com.djn.ems.service: 服务层
  - EmployeeService: Employee对象管理模块，内部使用数组管理一组对象，并提供相应的添加、删除和获取方法，供EmployeeView调用 
- com.djn.ems.main: 入口
  - EmployeeMain: 项目入口
- com.djn.ems.domain: 实体层，存放POJO类
  - Employee: 用来封装员工信息
  - Designer: 用来封装设计师的信息
  - Architect: 用来封装架构师的信息
  - Programmer: 用来封装程序员的信息


### 基于集合+io实现: ems-assemble
- 主要涉及知识点
  - 类和对象
  - 类的封装
  - 集合
  - 聚合、组合、多态
  - 抽象类
  - 异常
  - io流
  - 序列化
#### 需求说明
模拟实现基于文本界面的《员工管理系统》
- 能够实现员工对象的插入、修改和删除操作，能够打印员工明细表以及退出
- 软件启动时，根据给定的数据创建设备信息列表
- 开发人员(普通员工没有)增加了新的属性：领用设备
  - 设备有三种状态：空闲、在用和报废
- 每个员工信息被保存在Employee对象中
- 员工信息包括：编号、姓名、年龄、工资
- 员工有职位的不同：架构师、设计师、程序员和普通员工
- 有的员工有奖金(bouns)和股票(stock), 普通员工和程序员只有工资，架构师有奖金和股票，设计师有奖金
- 公司对于开发人员组成要求：最多两名架构师，最多三名设计师和最多五名程序员
- 操作员工的失败信息使用异常处理
  - 失败信息包括：
    - 设备正在使用中，无法领用(在View层抛异常)
    - 设备已经报废，无法领用(在View层抛异常)
    - 开发人员已满，无法添加
    - 团队中只能有两名架构师
    - 团队中只能有三名设计师
    - 团队中只能由五名程序员

#### 设计结构
软件由四个模块构成：
- com.djn.ems.view: 视图层, 设备管理和人员管理部分在此关联，领用设备逻辑也在视图层完成，通过set方法
  - EmployeeView: 菜单显示和处理用户操作
- com.djn.ems.service: 服务层
  - EmployeeService: Employee对象管理模块，内部使用数组管理一组对象，并提供相应的添加、删除和获取方法，供EmployeeView调用
  - EMSException: 项目自定义异常
  - Status: 表示设备的三种状态：FREE(空闲)、USED(在用)、SCRAP(报废)
    - 状态切换在视图层
  - EquipmentService: 管理设备对象
  - Data: 在没有数据库时候，简单使用一个枚举类存放设备初始数据(二维数组)
- com.djn.ems.main: 入口
  - EmployeeMain: 项目入口
- com.djn.ems.domain: 实体层
  - Employee: 用来封装员工信息
  - Designer: 用来封装设计师的信息
  - Architect: 用来封装架构师的信息
  - Programmer: 用来封装程序员的信息
  - Equipment: 用来封装设备信息，是一个抽象类
    - PC: 继承Equipment
    - NoteBook: 继承Equipment
    - NotePad: 继承Equipment
- com.djn.ems.dao: Data Access Object数据访问对象，专门用于处理数据的读取和写入
  - EquipmentDAO
  - EmployeeDAO 从EquipmentService做一个简单的分离

> 读取resources目录中的文件, 要看编译打包后文件的位置，
> 要通过 类.class.getClassLoader().getResources(\[resources下的文件路径\]).getFile() 获取绝对路径，但是路径最前面有一个/要去掉

### 基于数据库+jdbc实现



