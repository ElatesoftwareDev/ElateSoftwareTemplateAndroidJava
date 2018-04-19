#Общее описание#
---------
Наша архитектура схожа с проектом: https://github.com/android10/Android-CleanArchitecture

**Основной стек технологий и библиотек:**

*  Clean Arcitecture
    *  https://www.youtube.com/watch?v=Nsjsiz2A9mg
    *  https://github.com/AndroidArchitecture/AndroidArchitectureBook
    *  https://habrahabr.ru/company/mobileup/blog/335382/
    *  https://github.com/ImangazalievM/CleanArchitectureManifest/blob/master/README.md
*  MVP by Moxy
    *  https://habrahabr.ru/post/276189/
    *  https://github.com/Arello-Mobile/Moxy
*  Rx Java 2
*  Dagger 2
    *  https://habrahabr.ru/post/279641/
	*  https://habrahabr.ru/post/335940/
	*  https://habrahabr.ru/post/279125/
*  Retrofit 2
*  Room
*  ButterKnife
    *  http://jakewharton.github.io/butterknife/
*  Gson

#Структура проекта#
---------
Проект реализует MVP с помощью Moxy, причем слой "M" в соответствии с принципами Чистой архитектуры разбивается еще на бизнес-логику(модуль domain) и провайдинг данных (модуль data).

Обычно проект разделяется на 3 модуля. Это позволяет уже на уровне модулей запретить использовать android-классы на слое бизнес логики,
а также запретить ограничить использование некоторых библиотек на определенном уровне(модуле).

*  **data (Android library)** - то, откуда приходят данные
*  **domain (Java library)** - бизнес логика
*  **presentation (Phone\Tablet module)** - слой отображения

## presentation ##
Слой который отвечает за отображение информации. Знает про Android.
Содержит:

 -  _application_ - содержит класс наследние Application
 -  _di_ - пакет для работы с di (Dagger 2)
 -  _features_ - содержит вью с презентерами, логически разбитыми по фичам.
 -  _threads_ - содержит реализацию интерфеса, который говорит в каком потоке должны обрабатываться ответы от UseCases.
 -  _utils_ - файлы утилиты.
 
### Dependency injection ###
 -  annotations - кастомные Scope аннотации.
 -  components - компоненты приложения
 -  modules - все модули.
 
 С помощью Dagger 2 строится граф зависимостей. Это позволяет не инициализировать все возможные элементы системы при старте приложения, а внедрять их по мере надобности.
 
 **Injector** - класс, который позволяет инициализировать и добавлять компоненты к уже существующим.  
 **PerActivity, PerFragment** - Scope аннотации, которые дают возможность управлять "временем жизни объектов". В данном случае они означают соотвественно "жить пока жива активити" и "жить пока жива фрагмент"  
 **AppComponent** - главный компонент приложения. Он включает в себя зависимости, которые нужно во время существования приложения.  
 **Обычно на каждую фичи создается отдельный компонент.**  
 **Модули** - сущности предоставляющие объекты. Обычно также создаются на каждую фичи.
### Features ###
Содержит:
 *  base - базовые активити, фрагменты, view интерфейсы
 *  пакеты по фичам
 
#### Некоторые особенности базовых классов. ####
**BaseActivity** - базовая активити, от которой наследуется большенство активити проекта. Имеет базовые методы для работы с активити, а также реализет внедрение компонента (метод injectComponent), удобно биндит вьюхи с помощью ButterKnife (переопределяя setContentView).
**BaseFragment** - базовый фрагмент также управлеяет внедрением компонента и разруливает ButterKnife. Важно понимать, что вьюхи инициализируются только после onViewCreated. сontext - именно ApplicationContext, потому что активити может и не быть.  
**BasePresenter** - базовый призентер. Позволяет обрабатывать ошибки.  

#### Остальное. #### 
**Активи и фрагменты** - Вьюха обычно глупая, ничего не делает, пробрасывает события в презентер. Инжектит презентер таким образом (связано с особенностями инжекта Moxy):

    `@InjectPresenter
    ChatPresenter presenter;

    @Inject
    Provider<ChatPresenter> presenterProvider;

    @ProvidePresenter
    ChatPresenter providePresenter() {
        return presenterProvider.get();
    }`
**Интерфейсы View** - Нужны чтобы презентер знал о вьюхе через интерфейс. Здесь Moxy позволяет задавать стратегии восстановления действий из ViewState.  
**Презентеры** - управляют отображением, взаимодействуют с бизнес-логикой. Инжектят интеракторы в себя. Отписываются от интеракторов (interactor.dispose())

**Таким образом для реализации какого-либо экрана нужно:)**
 -  Создать модуль (модули)
 -  Создать компонент даггера. Добавить необходимые модули.
 -  Добавить в класс Injector plus\clear методы.
 -  Создать интерфейс вью
 -  Создать презентер
 -  Создать реализацию интерфейса вью
 -  Связать презентер и вью. 

## domain ##
Модуль отвечает за бизнес-логику системы. Ничего не знает про Android.

 -  _entities_ - Модели данных, которыми оперирует система. Для простоты они могут использоваться и на других слоях.
 -  _executor_ - содержит интерфейсы, в которых будут выполняться и обрабатываться варианты использования.
 -  _interactors_ - содержит интеракторы - сущности, которые предстовляют совокупность вариантов использования необходимых для реализации некоторой фичи. **По сути интерактор = совокупность UseCases.**
 -  _repository_ - Entity Getaway. Интерфейс из которого слой бизнес логики получает данные. Обычно один большой интерфейс.
 -  _usecases_ - Варианты использования, реализующие паттерн Command.
 
**Описание классов**
 **BaseUseCase** - сущность, которая знает откуда брать данные и знает где выполняться.  
 **CompletableUseCase, ObservableUseCase** - сущности, которые умеют выполняться (метод execute), имеют входные и выходные параметры InParams, OutParams. Наличие различных реализаций связано с особенностями RxJava.  
 **Как реализовать UseCase?** - наследуемся от соответствующего базого типа (CompletableUseCase, ObservableUseCase и т.п. ), если необходимо передавать несколько параметров в usecase, необходимо создать InParam модель. Затем нужно реализовать метод buildUseCase - который как раз и представляет то, что делает UseCase. Все, теперь данные вариант использования можно запускать в интеракторе.
 
 **Интеракторы** - умеют вызвать UseCase (имеют методы для каждого типа UseCase), а также отписываются от вариантов использования при необходимости (метод dispose в классе BaseInteractor)
 
 
 
 
 

 
