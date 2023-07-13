package uz.gita.dima.mobile_banking.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts.AccountScreenDirection
import uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts.AccountScreenDirectionImpl
import uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts.dialog.MenuDialogDirection
import uz.gita.dima.mobile_banking.presentation.ui.home.pages.accounts.dialog.MenuDialogDirectionImpl
import uz.gita.dima.mobile_banking.presentation.ui.login.LoginScreenDirection
import uz.gita.dima.mobile_banking.presentation.ui.login.LoginScreenDirectionImpl
import uz.gita.dima.mobile_banking.presentation.ui.pin.PinScreenDirection
import uz.gita.dima.mobile_banking.presentation.ui.pin.PinScreenDirectionImpl
import uz.gita.dima.mobile_banking.presentation.ui.register.RegisterScreenDirection
import uz.gita.dima.mobile_banking.presentation.ui.register.RegisterScreenDirectionImpl
import uz.gita.dima.mobile_banking.presentation.ui.splash.SplashScreenDirection
import uz.gita.dima.mobile_banking.presentation.ui.splash.SplashScreenDirectionImpl
import uz.gita.dima.mobile_banking.presentation.ui.transfer.TransferScreenDirection
import uz.gita.dima.mobile_banking.presentation.ui.transfer.TransferScreenDirectionImp
import uz.gita.dima.mobile_banking.presentation.ui.transfer.verify.TransferVerifyScreenDirection
import uz.gita.dima.mobile_banking.presentation.ui.transfer.verify.TransferVerifyScreenDirectionImpl
import uz.gita.dima.mobile_banking.presentation.ui.verify.login.LoginVerifyScreenDirection
import uz.gita.dima.mobile_banking.presentation.ui.verify.login.LoginVerifyScreenDirectionImpl
import uz.gita.dima.mobile_banking.presentation.ui.verify.register.RegisterVerifyScreenDirection
import uz.gita.dima.mobile_banking.presentation.ui.verify.register.RegisterVerifyScreenDirectionImpl

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionsModule {

    @Binds
    fun bindSplashScreen(impl: SplashScreenDirectionImpl): SplashScreenDirection

    @Binds
    fun bindMenuDialog(impl: MenuDialogDirectionImpl): MenuDialogDirection

    @Binds
    fun bindAccountScreen(impl: AccountScreenDirectionImpl): AccountScreenDirection

    @Binds
    fun bindLoginScreen(impl: LoginScreenDirectionImpl): LoginScreenDirection

    @Binds
    fun bindPinScreen(impl: PinScreenDirectionImpl): PinScreenDirection

    @Binds
    fun bindRegisterScreen(impl: RegisterScreenDirectionImpl): RegisterScreenDirection

    @Binds
    fun bindTransferVerifyScreen(impl: TransferVerifyScreenDirectionImpl): TransferVerifyScreenDirection

    @Binds
    fun bindTransferScreen(impl: TransferScreenDirectionImp): TransferScreenDirection

    @Binds
    fun bindLoginVerifyScreen(impl: LoginVerifyScreenDirectionImpl): LoginVerifyScreenDirection

    @Binds
    fun bindRegisterVerifyScreen(impl: RegisterVerifyScreenDirectionImpl): RegisterVerifyScreenDirection

}