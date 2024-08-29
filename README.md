# studying-jetpack-compose-android

Jetpack Compose를 활용하여 간단한 뉴스 어플리케이션을 제작했습니다.
해당 어플리케이션은 다음과 같은 아키텍쳐 및 구조를 따릅니다.

MVVM : Compose와 같은 선언형 UI가 유행하면서 해당 디자인 패턴을 구글에서 추천하고 있기 때문에 해당 디자인 패턴을 채택하였습니다.
CleanArchitecture : 해당 CleanArchitecture는 기존의 로버트 C.마틴씨가 제시한 CleanArchitecture와 다른 Architecture입니다. [NowInAndroid](https://github.com/android/nowinandroid)를 통한 패턴을 활용하였습니다.
Dagger Hilt : Dagger Hilt를 통해서 외부로부터 의존성을 주입 받도록 추가했습니다.


