package models;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import tables.T_User;

public class UserForm {

    public String searchWord;
    
    public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}


	public List<UserItem> search() {
        List<T_User> list;
        if (StringUtils.isBlank(searchWord)) {
            list = T_User.find.all();
        } else {
            list = T_User.find.fuzzy(searchWord, "name");
        }
        return list.stream()
                .map(UserItem::new)
                .collect(Collectors.toList());
    }
}