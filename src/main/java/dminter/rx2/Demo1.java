package dminter.rx2;

import dminter.utils.Xutils;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {

//        demo1();
//        demo2();
//        demo3();
        demoZip();
    }

    private static void demo2() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new RuntimeException());
                emitter.onNext(4);
                emitter.onComplete();
                emitter.onNext(5);
//                emitter.onError(new RuntimeException());
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer value) {
                Xutils.debug("onNext:" + value);
            }

            @Override
            public void onError(Throwable e) {
                Xutils.debug("onError:" + e);
            }

            @Override
            public void onComplete() {
                Xutils.debug("onComplete:");
            }
        });


    }

    private static void demo3() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onComplete();
                emitter.onNext(5);
            }
        }).subscribe(new Observer<Integer>() {
            Disposable disposable;
            int i = 1;

            @Override
            public void onSubscribe(Disposable d) {

                disposable = d;
            }

            @Override
            public void onNext(Integer value) {
                i++;
                if (i == 2) {
                    disposable.dispose();
                }
                Xutils.debug("onNext:" + value);
            }

            @Override
            public void onError(Throwable e) {
                Xutils.debug("onError:" + e);
            }

            @Override
            public void onComplete() {
                Xutils.debug("onComplete:");
            }
        });


    }

    private static void demo4() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onComplete();
                emitter.onNext(5);

                Xutils.debug("Observable:"+Thread.currentThread().getName());
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer value) throws Exception {
                Xutils.debug("onNext:" + value);
                Xutils.debug("Observer:"+Thread.currentThread().getName());
            }
        });

    } private static void demoMap() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onComplete();
                emitter.onNext(5);
            }
        }).map(new Function<Integer, String>() {


            @Override
            public String apply(Integer integer) throws Exception {
                return "integer to String :"+integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String value) throws Exception {
                Xutils.debug("onNext:" + value);
            }
        });

    }
private static void demoFlatMap() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onComplete();
                emitter.onNext(5);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
//            concatMap
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                final List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("I am value " + integer);
                }
                return Observable.fromIterable(list);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String value) throws Exception {
                Xutils.debug("onNext:" + value);
            }
        });

    }

    private static void demoZip() {
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Xutils.debug( "emit 1");
                emitter.onNext(1);
                Xutils.debug( "emit 2");
                emitter.onNext(2);
                Xutils.debug( "emit 3");
                emitter.onNext(3);
                Xutils.debug( "emit 4");
                emitter.onNext(4);
                Xutils.debug( "emit complete1");
                emitter.onComplete();
            }
        });

        Observable<String> observable2 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Xutils.debug( "emit A");
                emitter.onNext("A");
                Xutils.debug( "emit B");
                emitter.onNext("B");
                Xutils.debug( "emit C");
                emitter.onNext("C");
                Xutils.debug( "emit complete2");
                emitter.onComplete();
            }
        });

        Observable.zip(observable1, observable2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Xutils.debug( "onSubscribe");
            }

            @Override
            public void onNext(String value) {
                Xutils.debug( "onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {
                Xutils.debug( "onError");
            }

            @Override
            public void onComplete() {
                Xutils.debug( "onComplete");
            }
        });
    }

    private static void demo5() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Xutils.debug("Observable:"+Thread.currentThread().getName());
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();

            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Xutils.debug("onSubscribe:" + d);
            }

            @Override
            public void onNext(Integer value) {
                Xutils.debug("onNext:" + value);
                Xutils.debug("Observer:"+Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                Xutils.debug("onError:" + e);
            }

            @Override
            public void onComplete() {
                Xutils.debug("onComplete:");
            }
        };


//        observable.subscribeOn(Schedulers.newThread())
//                .observeOn(Schedulers.newThread())
//                .subscribe(observer);
        observable.subscribe(observer);
    }

    private static void demo1() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Xutils.debug("onSubscribe:" + d);
            }

            @Override
            public void onNext(Integer value) {
                Xutils.debug("onNext:" + value);
            }

            @Override
            public void onError(Throwable e) {
                Xutils.debug("onError:" + e);
            }

            @Override
            public void onComplete() {
                Xutils.debug("onComplete:");
            }
        };


        observable.subscribe(observer);
    }
}
