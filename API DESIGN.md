## API设计

### 关于用户（user）

| 所用方法 |       url       |           请求参数           |  返回参数   |              描述              |    控制器名    | 完成 |
| :------: | :-------------: | :--------------------------: | :---------: | :----------------------------: | :------------: | ---- |
|   post   |   /user/login   |       user_id password       | status_code |        判断能否登录成功        |   verifyUser   |      |
|   put    |      /user      | user_id password name avatar | status_code |          更新用户信息          | updateUserById | 1    |
|   get    | /user/{user_id} |            token             |  user_data  | 根据所提交的用户id获取用户信息 |  getUserById   | 1    |
|   post   |      /user      |          User user           | status_code |            插入用户            |   insertUser   | 1    |



### 关于任务（task）

| 所用方法 |                        url                         |                      请求参数                       |    返回参数    |                             描述                             |        控制器名         |
| :------: | :------------------------------------------------: | :-------------------------------------------------: | :------------: | :----------------------------------------------------------: | :---------------------: |
|   get    |               /{user_id}/totalTasks                |                       user_id                       |   List<Task>   |                   获取某一个用户的总任务表                   |      getTotalTasks      |
|   get    |               /{user_id}/todayTasks                |                       user_id                       |   List<Task>   |                     获取某用户的今日任务                     |      getTodayTasks      |
|   get    |               /{user_id}/OwnTaskList               |                       user_id                       | List<TaskList> |          根据所提交的用户id获取用户自定义的任务列表          |     getOwnTaskList      |
|   get    |              /{user_id}/{TaskListId}               |                user_id,task_list_id                 |   List<Task>   |  根据所提交的用户id和任务列表id获取该自定义分类下的任务列表  | getTaskListByTaskListId |
|   get    |                  /{user_id}/plans                  |                       user_id                       | List<TaskList> |         根据用户id返回所提交的计划（任务的分层结构）         |        getPlans         |
|   post   |                  /{user_id}/task                   |                  Task、TaskListId                   |  stutus_code   | 用户提交描述一个任务的表单,可以提交到各个分类(由taskListId标识)中 |         addTask         |
|   post   |           /{user_id}/taskList/taskListId           |                      TaskList                       |  stutus_code   | 用户提交描述一个任务列表的表单,可以提交到各个分类(由taskListId标识)中 |       addTaskList       |
|   put    |               /{user_id}/task/taskId               |                        task                         |  stutus_code   | 用户提交描述一个任务的表单,可以修改分类(由taskListId标识)中  |       updateTask        |
|   put    |                /{user_id}/taskList                 |                      TaskList                       |  stutus_code   | 用户提交描述一个任务列表的表单,可以提交到各个分类(由taskListId标识)中 |     updateTaskList      |
|  delete  |             /{user_id}/task/{task_Id}              |                       task_id                       |  stutus_code   |             根据删除的task_id删除task表中的数据              |       deleteTask        |
|  delete  |         /{user_id}/taskList/{taskList_id}          |                       task_id                       |  stutus_code   |         根据删除的taskList_id删除taskList表中的数据          |     deleteTaskList      |
|   post   | /{user_id}/task/{taskId}/{taskListId}/{taskListId} | taskId、taskList_Id（源列表）、taskListId（新列表） |  stutus_code   |              把某个task从一个分类中转移到另一个              |        moveTask         |
|          |                                                    |                                                     |                |                                                              |                         |
|          |                                                    |                                                     |                |                                                              |                         |
|          |                                                    |                                                     |                |                                                              |                         |
|          |                                                    |                                                     |                |                                                              |                         |
|          |                                                    |                                                     |                |                                                              |                         |

