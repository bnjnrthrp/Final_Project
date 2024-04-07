public interface IView<T> {
  void showADTList(ADTList<T> list);
  void showString(String str);
  void showOptions();
  void showInt(int number);

}
