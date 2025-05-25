import { twMerge } from "tailwind-merge";

type ButtonProps = React.ButtonHTMLAttributes<HTMLButtonElement> & {
  label: string;
};

export function Button({ label, className, ...rest }: ButtonProps) {
  return (
    <button
      {...rest}
      className={twMerge(
        "bg-[#C78E00] w-3xs text-white font-medium py-5 px-6 rounded-[6px] transition-colors duration-200 hover:bg-[#a97600] disabled:opacity-50 mt-7 self-center cursor-pointer",
        className
      )}
    >
      {label}
    </button>
  );
}
