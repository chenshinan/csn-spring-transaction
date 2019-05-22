package liquibase


databaseChangeLog(logicalFilePath: 'project.groovy') {

    changeSet(id: '2018-08-26-create-project', author: 'shinan.chen') {
        createTable(tableName: "project", remarks: '项目issue编号基准表') {
            column(name: 'project_id', type: 'BIGINT UNSIGNED', autoIncrement: true, remarks: '主键') {
                constraints(primaryKey: true)
            }
            column(name: 'project_code', type: 'VARCHAR(255)', remarks: '项目code')
            column(name: 'issue_max_num', type: 'BIGINT UNSIGNED', remarks: 'issue编号最大值')
        }
    }
}