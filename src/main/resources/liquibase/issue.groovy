package liquibase


databaseChangeLog(logicalFilePath: 'issue.groovy') {

    changeSet(id: '2018-08-26-create-issue-type', author: 'shinan.chen') {
        createTable(tableName: 'issue_type') {
            column(name: 'id', type: 'BIGINT UNSIGNED', autoIncrement: 'true', remarks: 'ID,主键') {
                constraints(primaryKey: 'true')
            }
            column(name: 'name', type: 'VARCHAR(64)', remarks: '名称') {
                constraints(nullable: 'false')
            }
            column(name: 'description', type: 'VARCHAR(255)', remarks: '描述')

            column(name: 'icon', type: 'VARCHAR(64)', remarks: '图标')

            column(name: "object_version_number", type: "BIGINT UNSIGNED", defaultValue: "1")
            column(name: "created_by", type: "BIGINT UNSIGNED", defaultValue: "0")
            column(name: "creation_date", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "last_updated_by", type: "BIGINT UNSIGNED", defaultValue: "0")
            column(name: "last_update_date", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
        }
        createIndex(tableName: "issue_type", indexName: "issue_type_n1") {
            column(name: "name", type: "VARCHAR(64)")
        }
        createIndex(tableName: "issue_type", indexName: "issue_type_n2") {
            column(name: "description", type: "VARCHAR(255)")
        }
    }
}