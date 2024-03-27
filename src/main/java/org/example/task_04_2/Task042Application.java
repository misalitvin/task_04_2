package org.example.task_04_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Task042Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Task042Application.class, args);
		ArticleRepository articleRepository = context.getBean(ArticleRepository.class);
		BlogRepository blogRepository = context.getBean(BlogRepository.class);
		RoleRepository roleRepository = context.getBean(RoleRepository.class);
		UserRepository userRepository = context.getBean(UserRepository.class);
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			System.out.println("Choose the action you want to perform");
			System.out.println("1 - View");
			System.out.println("2 - add");
			System.out.println("3 - Delete");
			System.out.println("4 - Exit");
			int action = scanner.nextInt();
			System.out.println("Select the table");
			System.out.println("1 - Article");
			System.out.println("2 - Blog");
			System.out.println("3 - Role");
			System.out.println("4 - User");
			int action2 = scanner.nextInt();
			switch (action) {
				case 1:
					switch (action2) {
						case 1:
							System.out.println("1 - View by ID");
							System.out.println("2 - View All");
							int viewChoice = scanner.nextInt();
							switch (viewChoice) {
								case 1:
									System.out.println("Enter ID of the article:");
									Long articleId = scanner.nextLong();
									System.out.println(articleRepository.view(articleId));
									break;
								case 2:
									for(Article article: articleRepository.viewAll()){
										System.out.println(article);
									};
									break;
							}
							break;
						case 2:
							System.out.println("1 - View by ID");
							System.out.println("2 - View All");
							int blogViewChoice = scanner.nextInt();
							switch (blogViewChoice) {
								case 1:
									System.out.println("Enter ID of the blog:");
									Long blogId = scanner.nextLong();
									System.out.println(blogRepository.view(blogId));
									break;
								case 2:
									for(Blog blog:blogRepository.viewAll()){
										System.out.println(blog);
									}
									break;
							}
							break;
						case 3:
							System.out.println("1 - View by ID");
							System.out.println("2 - View All");
							int roleViewChoice = scanner.nextInt();
							switch (roleViewChoice) {
								case 1:
									System.out.println("Enter ID of the role:");
									Long roleId = scanner.nextLong();
									System.out.println(roleRepository.view(roleId));
									break;
								case 2:
									for(Role role:roleRepository.viewAll()){
										System.out.println(role);
									}
									break;
							}
							break;
						case 4:
							System.out.println("1 - View by ID");
							System.out.println("2 - View All");
							int userViewChoice = scanner.nextInt();
							switch (userViewChoice) {
								case 1:
									System.out.println("Enter ID of the user:");
									Long userId = scanner.nextLong();
									System.out.println(userRepository.view(userId));
									break;
								case 2:
									for(User user:userRepository.viewAll()){
										System.out.println(user);
									};
									break;
							}
							break;

					}
					break;
				case 2:
					switch (action2) {
						case 1:
							System.out.println("Enter title of the article:");
							String artitle = scanner.nextLine();artitle = scanner.nextLine();
							System.out.println("Enter ID of the user:");
							Long userId = scanner.nextLong();
							System.out.println("Enter ID of the blog:");
							Long blogId = scanner.nextLong();
							User u = userRepository.findById(userId).orElse(null);
							Blog blog = blogRepository.findById(blogId).orElse(null);
							Article article = new Article(artitle,u,blog);
							articleRepository.save(article);
							break;
						case 2:
							System.out.println("Enter name of the blog:");
							String blogname = scanner.nextLine();blogname = scanner.nextLine();
							System.out.println("Enter ID of the user:");
							userId = scanner.nextLong();
							User user = userRepository.findById(userId).orElse(null);
							Blog b = new Blog(blogname, user);
							blogRepository.save(b);
							break;
						case 3:
							System.out.println("Enter name of the role:");
							String rolename = scanner.nextLine();rolename = scanner.nextLine();
							Role role = new Role(rolename);
							roleRepository.save(role);
							break;
						case 4:
							System.out.println("Enter mail of the user:");
							String usermail = scanner.nextLine();usermail = scanner.nextLine();
							User uuu = new User(usermail);
							userRepository.save(uuu);
							break;
					}
					break;
				case 3:
					switch (action2) {
						case 1:
							System.out.println("Enter ID of the article:");
							Long articleId = scanner.nextLong();
							articleRepository.deleteById(articleId);
							break;
						case 2:
							System.out.println("Enter ID of the blog:");
							Long blogId = scanner.nextLong();
							blogRepository.deleteById(blogId);
							break;
						case 3:
							System.out.println("Enter ID of the role:");
							Long roleId = scanner.nextLong();
							roleRepository.deleteById(roleId);
							break;
						case 4:
							System.out.println("Enter ID of the user:");
							Long userId = scanner.nextLong();
							userRepository.deleteById(userId);
							break;

					}
					break;
				case 4:
					exit = true;
			}
		}
	}
}
