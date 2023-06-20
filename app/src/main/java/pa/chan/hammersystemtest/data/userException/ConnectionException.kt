package pa.chan.hammersystemtest.data.userException

object ConnectionException: Throwable(), UserError {
    override val errorMessage: String
        get() = "Проверьте свое соединение с интернетом"
}